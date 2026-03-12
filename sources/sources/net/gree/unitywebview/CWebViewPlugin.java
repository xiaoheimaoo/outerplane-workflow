package net.gree.unitywebview;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.common.net.HttpHeaders;
import com.unity3d.player.UnityPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class CWebViewPlugin extends Fragment {
    private static final int INPUT_FILE_REQUEST_CODE = 1;
    private static long instanceCount;
    private static FrameLayout layout;
    private boolean canGoBack;
    private boolean canGoForward;
    private boolean mAlertDialogEnabled;
    private boolean mAllowAudioCapture;
    private Pattern mAllowRegex;
    private boolean mAllowVideoCapture;
    private String mBasicAuthPassword;
    private String mBasicAuthUserName;
    private Uri mCameraPhotoUri;
    private Hashtable<String, String> mCustomHeaders;
    private Pattern mDenyRegex;
    private ValueCallback<Uri[]> mFilePathCallback;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private Pattern mHookRegex;
    private long mInstanceId;
    private boolean mPaused;
    private List<Pair<String, CWebViewPlugin>> mTransactions;
    private ValueCallback<Uri> mUploadMessage;
    private View mVideoView;
    private WebView mWebView;
    private CWebViewPluginInterface mWebViewPlugin;
    private String mWebViewUA;
    private int progress;
    private Queue<String> mMessages = new ArrayDeque();
    private boolean mInteractionEnabled = true;

    public void SaveDataURL(final String str, String str2) {
        String substring;
        int indexOf;
        if (str2.startsWith("data:") && (indexOf = (substring = str2.substring(5)).indexOf(";")) >= 0) {
            final String substring2 = substring.substring(indexOf + 1 + 7);
            final String substring3 = substring.substring(0, indexOf);
            final Activity activity = UnityPlayer.currentActivity;
            activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    if (Build.VERSION.SDK_INT >= 29) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_display_name", str);
                        contentValues.put("mime_type", substring3);
                        contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
                        contentValues.put("is_pending", (Integer) 1);
                        ContentResolver contentResolver = activity.getContentResolver();
                        Uri insert = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
                        if (insert != null) {
                            byte[] decode = Base64.decode(substring2, 0);
                            try {
                                OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                                if (openOutputStream != null) {
                                    openOutputStream.write(decode);
                                }
                                if (openOutputStream != null) {
                                    openOutputStream.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        contentValues.clear();
                        contentValues.put("is_pending", (Integer) 0);
                        contentResolver.update(insert, contentValues, null, null);
                        return;
                    }
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str);
                    file.getParent();
                    String name = file.getName();
                    int lastIndexOf = name.lastIndexOf(".");
                    if (lastIndexOf >= 0) {
                        str3 = name.substring(lastIndexOf);
                        name = name.substring(0, lastIndexOf);
                    } else {
                        str3 = "";
                    }
                    int i = 1;
                    while (file.exists()) {
                        i++;
                        file = new File(file.getParent(), name + " (" + i + ")" + str3);
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(Base64.decode(substring2, 0));
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static boolean isDestroyed(Activity activity) {
        if (activity == null) {
            return true;
        }
        return activity.isDestroyed();
    }

    public void OnRequestFileChooserPermissionsResult(final boolean z) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (z) {
                    CWebViewPlugin.this.ProcessChooser();
                    return;
                }
                CWebViewPlugin.this.mFilePathCallback.onReceiveValue(null);
                CWebViewPlugin.this.mFilePathCallback = null;
            }
        });
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (this.mFilePathCallback == null) {
            super.onActivityResult(i, i2, intent);
        } else {
            if (i2 == -1) {
                if (intent == null) {
                    Uri uri = this.mCameraPhotoUri;
                    if (uri != null) {
                        uriArr = new Uri[]{uri};
                    }
                } else {
                    String dataString = intent.getDataString();
                    if (dataString == null) {
                        Uri uri2 = this.mCameraPhotoUri;
                        if (uri2 != null) {
                            uriArr = new Uri[]{uri2};
                        }
                    } else {
                        uriArr = new Uri[]{Uri.parse(dataString)};
                    }
                }
                this.mFilePathCallback.onReceiveValue(uriArr);
                this.mFilePathCallback = null;
            }
            uriArr = null;
            this.mFilePathCallback.onReceiveValue(uriArr);
            this.mFilePathCallback = null;
        }
    }

    public static boolean IsWebViewAvailable() {
        final Activity activity = UnityPlayer.currentActivity;
        FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: net.gree.unitywebview.CWebViewPlugin.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                boolean z;
                try {
                    new WebView(activity);
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        if (isDestroyed(activity)) {
            return false;
        }
        activity.runOnUiThread(futureTask);
        try {
            return ((Boolean) futureTask.get()).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public String GetMessage() {
        String poll;
        synchronized (this.mMessages) {
            poll = this.mMessages.size() > 0 ? this.mMessages.poll() : null;
        }
        return poll;
    }

    public void MyUnitySendMessage(String str, String str2, String str3) {
        synchronized (this.mMessages) {
            this.mMessages.add(str2 + ":" + str3);
        }
    }

    public boolean IsInitialized() {
        return this.mWebView != null;
    }

    public void Init(final String str, boolean z, boolean z2, int i, String str2, int i2) {
        final Activity activity = UnityPlayer.currentActivity;
        long j = instanceCount + 1;
        instanceCount = j;
        this.mInstanceId = j;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new AnonymousClass4(this, activity, i2, str, str2, z2, i, z));
        final View rootView = activity.getWindow().getDecorView().getRootView();
        this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: net.gree.unitywebview.CWebViewPlugin.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                rootView.getWindowVisibleDisplayFrame(rect);
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                try {
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    int i3 = point.y;
                } catch (NoSuchMethodError unused) {
                    defaultDisplay.getHeight();
                }
                int height = rootView.getRootView().getHeight() - (rect.bottom - rect.top);
                if (CWebViewPlugin.this.IsInitialized()) {
                    CWebViewPlugin.this.MyUnitySendMessage(str, "SetKeyboardVisible", Integer.toString(height));
                }
            }
        };
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: net.gree.unitywebview.CWebViewPlugin$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ Activity val$a;
        final /* synthetic */ int val$androidForceDarkMode;
        final /* synthetic */ String val$gameObject;
        final /* synthetic */ int val$radius;
        final /* synthetic */ CWebViewPlugin val$self;
        final /* synthetic */ boolean val$transparent;
        final /* synthetic */ String val$ua;
        final /* synthetic */ boolean val$zoom;

        AnonymousClass4(CWebViewPlugin cWebViewPlugin, Activity activity, int i, String str, String str2, boolean z, int i2, boolean z2) {
            this.val$self = cWebViewPlugin;
            this.val$a = activity;
            this.val$radius = i;
            this.val$gameObject = str;
            this.val$ua = str2;
            this.val$zoom = z;
            this.val$androidForceDarkMode = i2;
            this.val$transparent = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CWebViewPlugin.this.mWebView != null) {
                return;
            }
            CWebViewPlugin.this.setRetainInstance(true);
            if (CWebViewPlugin.this.mPaused) {
                if (CWebViewPlugin.this.mTransactions == null) {
                    CWebViewPlugin.this.mTransactions = new ArrayList();
                }
                CWebViewPlugin.this.mTransactions.add(Pair.create("add", this.val$self));
            } else {
                this.val$a.getFragmentManager().beginTransaction().add(0, this.val$self, "CWebViewPlugin" + CWebViewPlugin.this.mInstanceId).commitAllowingStateLoss();
            }
            CWebViewPlugin.this.mAlertDialogEnabled = true;
            CWebViewPlugin.this.mAllowVideoCapture = false;
            CWebViewPlugin.this.mAllowAudioCapture = false;
            CWebViewPlugin.this.mCustomHeaders = new Hashtable();
            final WebView roundedWebView = this.val$radius > 0 ? new RoundedWebView(this.val$a, this.val$radius) : new WebView(this.val$a);
            try {
                if ((this.val$a.getPackageManager().getApplicationInfo(this.val$a.getPackageName(), 0).flags & 2) != 0) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
            } catch (Exception unused) {
            }
            roundedWebView.setVisibility(8);
            roundedWebView.setFocusable(true);
            roundedWebView.setFocusableInTouchMode(true);
            roundedWebView.setWebChromeClient(new WebChromeClient() { // from class: net.gree.unitywebview.CWebViewPlugin.4.1
                @Override // android.webkit.WebChromeClient
                public void onPermissionRequest(PermissionRequest permissionRequest) {
                    String[] resources = permissionRequest.getResources();
                    for (String str : resources) {
                        if ((str.equals("android.webkit.resource.VIDEO_CAPTURE") && CWebViewPlugin.this.mAllowVideoCapture) || ((str.equals("android.webkit.resource.AUDIO_CAPTURE") && CWebViewPlugin.this.mAllowAudioCapture) || str.equals("android.webkit.resource.PROTECTED_MEDIA_ID"))) {
                            permissionRequest.grant(resources);
                            return;
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    CWebViewPlugin.this.progress = i;
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    if (CWebViewPlugin.layout != null) {
                        CWebViewPlugin.this.mVideoView = view;
                        CWebViewPlugin.layout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        CWebViewPlugin.layout.addView(CWebViewPlugin.this.mVideoView);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onHideCustomView() {
                    super.onHideCustomView();
                    if (CWebViewPlugin.layout != null) {
                        CWebViewPlugin.layout.removeView(CWebViewPlugin.this.mVideoView);
                        CWebViewPlugin.layout.setBackgroundColor(0);
                        CWebViewPlugin.this.mVideoView = null;
                    }
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                    if (!CWebViewPlugin.this.mAlertDialogEnabled) {
                        jsResult.cancel();
                        return true;
                    }
                    return super.onJsAlert(webView, str, str2, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                    if (!CWebViewPlugin.this.mAlertDialogEnabled) {
                        jsResult.cancel();
                        return true;
                    }
                    return super.onJsConfirm(webView, str, str2, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    if (!CWebViewPlugin.this.mAlertDialogEnabled) {
                        jsPromptResult.cancel();
                        return true;
                    }
                    return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }

                @Override // android.webkit.WebChromeClient
                public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                    callback.invoke(str, true, false);
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                    openFileChooser(valueCallback, str, "");
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                    if (CWebViewPlugin.this.mUploadMessage != null) {
                        CWebViewPlugin.this.mUploadMessage.onReceiveValue(null);
                    }
                    CWebViewPlugin.this.mUploadMessage = valueCallback;
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType("*/*");
                    CWebViewPlugin.this.startActivityForResult(intent, 1);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    CWebViewPlugin.this.mFilePathCallback = valueCallback;
                    CWebViewPlugin.this.MyUnitySendMessage(AnonymousClass4.this.val$gameObject, "RequestFileChooserPermissions", "");
                    return true;
                }
            });
            CWebViewPlugin.this.mWebViewPlugin = new CWebViewPluginInterface(this.val$self, this.val$gameObject);
            roundedWebView.setWebViewClient(new WebViewClient() { // from class: net.gree.unitywebview.CWebViewPlugin.4.2
                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    roundedWebView.loadUrl("about:blank");
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnError", i + "\t" + str + "\t" + str2);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnHttpError", Integer.toString(webResourceResponse.getStatusCode()));
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnStarted", str);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnLoaded", str);
                }

                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
                    if (CWebViewPlugin.this.mBasicAuthUserName != null && CWebViewPlugin.this.mBasicAuthPassword != null) {
                        httpAuthHandler.proceed(CWebViewPlugin.this.mBasicAuthUserName, CWebViewPlugin.this.mBasicAuthPassword);
                    } else {
                        httpAuthHandler.cancel();
                    }
                }

                @Override // android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    if (CWebViewPlugin.this.mCustomHeaders == null || CWebViewPlugin.this.mCustomHeaders.isEmpty()) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, CWebViewPlugin.this.mWebViewUA);
                        if (CWebViewPlugin.this.mBasicAuthUserName != null && CWebViewPlugin.this.mBasicAuthPassword != null) {
                            httpURLConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeToString((CWebViewPlugin.this.mBasicAuthUserName + ":" + CWebViewPlugin.this.mBasicAuthPassword).getBytes(), 2));
                        }
                        String cookie = CookieManager.getInstance().getCookie(str);
                        if (cookie != null && !cookie.isEmpty()) {
                            httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, cookie);
                        }
                        for (Map.Entry entry : CWebViewPlugin.this.mCustomHeaders.entrySet()) {
                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode < 300 || responseCode >= 400) {
                            List<String> list = httpURLConnection.getHeaderFields().get(HttpHeaders.SET_COOKIE);
                            if (list != null) {
                                CWebViewPlugin.this.SetCookies(str, list);
                            }
                            return new WebResourceResponse(httpURLConnection.getContentType().split(";", 2)[0], httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                        }
                        return null;
                    } catch (Exception unused2) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                }

                /* renamed from: net.gree.unitywebview.CWebViewPlugin$4$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                class AnonymousClass1 implements Runnable {
                    final /* synthetic */ List val$setCookieHeaders;
                    final /* synthetic */ String val$url;

                    AnonymousClass1(String str, List list) {
                        this.val$url = str;
                        this.val$setCookieHeaders = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        CWebViewPlugin.this.SetCookies(this.val$url, this.val$setCookieHeaders);
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    if ((CWebViewPlugin.this.mAllowRegex != null && CWebViewPlugin.this.mAllowRegex.matcher(str).find()) || CWebViewPlugin.this.mDenyRegex == null || !CWebViewPlugin.this.mDenyRegex.matcher(str).find()) {
                        if (str.startsWith("unity:")) {
                            CWebViewPlugin.this.mWebViewPlugin.call("CallFromJS", str.substring(6));
                            return true;
                        } else if (CWebViewPlugin.this.mHookRegex != null && CWebViewPlugin.this.mHookRegex.matcher(str).find()) {
                            CWebViewPlugin.this.mWebViewPlugin.call("CallOnHooked", str);
                            return true;
                        } else if (!str.toLowerCase().endsWith(".pdf") && !str.startsWith("https://maps.app.goo.gl") && (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("javascript:"))) {
                            CWebViewPlugin.this.mWebViewPlugin.call("CallOnStarted", str);
                            return false;
                        } else {
                            try {
                                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            } catch (ActivityNotFoundException unused2) {
                            }
                            return true;
                        }
                    }
                    return true;
                }
            });
            roundedWebView.addJavascriptInterface(CWebViewPlugin.this.mWebViewPlugin, "Unity");
            WebSettings settings = roundedWebView.getSettings();
            String str = this.val$ua;
            if (str != null && str.length() > 0) {
                settings.setUserAgentString(this.val$ua);
            }
            CWebViewPlugin.this.mWebViewUA = settings.getUserAgentString();
            if (this.val$zoom) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
                settings.setBuiltInZoomControls(false);
            }
            settings.setDisplayZoomControls(false);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setJavaScriptEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabasePath(roundedWebView.getContext().getDir("databases", 0).getPath());
            settings.setAllowFileAccess(true);
            if (Build.VERSION.SDK_INT >= 29) {
                int i = this.val$androidForceDarkMode;
                if (i == 0) {
                    int i2 = UnityPlayer.currentActivity.getResources().getConfiguration().uiMode & 48;
                    if (i2 == 16) {
                        settings.setForceDark(0);
                    } else if (i2 == 32) {
                        settings.setForceDark(2);
                    }
                } else if (i == 1) {
                    settings.setForceDark(0);
                } else if (i == 2) {
                    settings.setForceDark(2);
                }
            }
            if (this.val$transparent) {
                roundedWebView.setBackgroundColor(0);
            }
            roundedWebView.setOnTouchListener(new View.OnTouchListener() { // from class: net.gree.unitywebview.CWebViewPlugin.4.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return !CWebViewPlugin.this.mInteractionEnabled;
                }
            });
            if (CWebViewPlugin.layout == null || CWebViewPlugin.layout.getParent() != this.val$a.findViewById(16908290)) {
                FrameLayout unused2 = CWebViewPlugin.layout = new FrameLayout(this.val$a);
                this.val$a.addContentView(CWebViewPlugin.layout, new ViewGroup.LayoutParams(-1, -1));
                CWebViewPlugin.layout.setFocusable(true);
                CWebViewPlugin.layout.setFocusableInTouchMode(true);
            }
            CWebViewPlugin.layout.addView(roundedWebView, new FrameLayout.LayoutParams(-1, -1, 0));
            CWebViewPlugin.this.mWebView = roundedWebView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ProcessChooser() {
        /*
            r5 = this;
            r0 = 0
            r5.mCameraPhotoUri = r0
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.media.action.IMAGE_CAPTURE"
            r1.<init>(r2)
            android.app.Activity r2 = r5.getActivity()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            android.content.ComponentName r2 = r1.resolveActivity(r2)
            if (r2 == 0) goto L57
            java.io.File r2 = r5.createImageFile()     // Catch: java.io.IOException -> L1d
            goto L26
        L1d:
            r2 = move-exception
            java.lang.String r3 = "CWebViewPlugin"
            java.lang.String r4 = "Unable to create Image File"
            android.util.Log.e(r3, r4, r2)
            r2 = r0
        L26:
            if (r2 == 0) goto L58
            java.lang.String r0 = "PhotoPath"
            r1.putExtra(r0, r2)
            android.app.Activity r0 = r5.getActivity()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.app.Activity r4 = r5.getActivity()
            java.lang.String r4 = r4.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = ".unitywebview.fileprovider"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r0, r3, r2)
            r5.mCameraPhotoUri = r0
            java.lang.String r2 = "output"
            r1.putExtra(r2, r0)
        L57:
            r0 = r1
        L58:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.GET_CONTENT"
            r1.<init>(r2)
            java.lang.String r2 = "android.intent.category.OPENABLE"
            r1.addCategory(r2)
            java.lang.String r2 = "android.intent.extra.ALLOW_MULTIPLE"
            r3 = 1
            r1.putExtra(r2, r3)
        */
        //  java.lang.String r2 = "*/*"
        /*
            r1.setType(r2)
            r2 = 0
            if (r0 == 0) goto L77
            android.content.Intent[] r4 = new android.content.Intent[r3]
            r4[r2] = r0
            goto L79
        L77:
            android.content.Intent[] r4 = new android.content.Intent[r2]
        L79:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.CHOOSER"
            r0.<init>(r2)
            java.lang.String r2 = "android.intent.extra.INTENT"
            r0.putExtra(r2, r1)
            java.lang.String r1 = "android.intent.extra.INITIAL_INTENTS"
            r0.putExtra(r1, r4)
            java.lang.String r1 = "Select images"
            android.content.Intent r0 = android.content.Intent.createChooser(r0, r1)
            r5.startActivityForResult(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gree.unitywebview.CWebViewPlugin.ProcessChooser():void");
    }

    private File createImageFile() throws IOException {
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
        File externalFilesDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return File.createTempFile(str, ".jpg", externalFilesDir);
    }

    public void Destroy() {
        final Activity activity = UnityPlayer.currentActivity;
        final WebView webView = this.mWebView;
        this.mWebView = null;
        this.mMessages.clear();
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                if (webView == null) {
                    return;
                }
                if (CWebViewPlugin.this.mGlobalLayoutListener != null) {
                    activity.getWindow().getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(CWebViewPlugin.this.mGlobalLayoutListener);
                    CWebViewPlugin.this.mGlobalLayoutListener = null;
                }
                webView.stopLoading();
                if (CWebViewPlugin.this.mVideoView != null) {
                    CWebViewPlugin.layout.removeView(CWebViewPlugin.this.mVideoView);
                    CWebViewPlugin.layout.setBackgroundColor(0);
                    CWebViewPlugin.this.mVideoView = null;
                }
                CWebViewPlugin.layout.removeView(webView);
                webView.destroy();
                if (CWebViewPlugin.this.mPaused) {
                    if (CWebViewPlugin.this.mTransactions == null) {
                        CWebViewPlugin.this.mTransactions = new ArrayList();
                    }
                    CWebViewPlugin.this.mTransactions.add(Pair.create("remove", this));
                    return;
                }
                activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0022 A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:4:0x0004, B:7:0x000b, B:10:0x0013, B:13:0x001a, B:16:0x0022, B:19:0x0029, B:20:0x002d, B:23:0x0036), top: B:27:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[Catch: Exception -> 0x0040, TRY_LEAVE, TryCatch #0 {Exception -> 0x0040, blocks: (B:4:0x0004, B:7:0x000b, B:10:0x0013, B:13:0x001a, B:16:0x0022, B:19:0x0029, B:20:0x002d, B:23:0x0036), top: B:27:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean SetURLPattern(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L10
            int r2 = r4.length()     // Catch: java.lang.Exception -> L40
            if (r2 != 0) goto Lb
            goto L10
        Lb:
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Exception -> L40
            goto L11
        L10:
            r4 = r1
        L11:
            if (r5 == 0) goto L1f
            int r2 = r5.length()     // Catch: java.lang.Exception -> L40
            if (r2 != 0) goto L1a
            goto L1f
        L1a:
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)     // Catch: java.lang.Exception -> L40
            goto L20
        L1f:
            r5 = r1
        L20:
            if (r6 == 0) goto L2d
            int r2 = r6.length()     // Catch: java.lang.Exception -> L40
            if (r2 != 0) goto L29
            goto L2d
        L29:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r6)     // Catch: java.lang.Exception -> L40
        L2d:
            android.app.Activity r6 = com.unity3d.player.UnityPlayer.currentActivity     // Catch: java.lang.Exception -> L40
            boolean r2 = isDestroyed(r6)     // Catch: java.lang.Exception -> L40
            if (r2 == 0) goto L36
            return r0
        L36:
            net.gree.unitywebview.CWebViewPlugin$7 r2 = new net.gree.unitywebview.CWebViewPlugin$7     // Catch: java.lang.Exception -> L40
            r2.<init>()     // Catch: java.lang.Exception -> L40
            r6.runOnUiThread(r2)     // Catch: java.lang.Exception -> L40
            r4 = 1
            return r4
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.gree.unitywebview.CWebViewPlugin.SetURLPattern(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public void LoadURL(final String str) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (CWebViewPlugin.this.mCustomHeaders == null || CWebViewPlugin.this.mCustomHeaders.isEmpty()) {
                    CWebViewPlugin.this.mWebView.loadUrl(str);
                } else {
                    CWebViewPlugin.this.mWebView.loadUrl(str, CWebViewPlugin.this.mCustomHeaders);
                }
            }
        });
    }

    public void LoadHTML(final String str, final String str2) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.9
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.loadDataWithBaseURL(str2, str, "text/html", "UTF8", null);
            }
        });
    }

    public void EvaluateJS(final String str) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.10
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.evaluateJavascript(str, null);
            }
        });
    }

    public void GoBack() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.11
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.goBack();
            }
        });
    }

    public void GoForward() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.12
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.goForward();
            }
        });
    }

    public void Reload() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.13
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.reload();
            }
        });
    }

    public void SetMargins(int i, int i2, int i3, int i4) {
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 0);
        layoutParams.setMargins(i, i2, i3, i4);
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.14
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.setLayoutParams(layoutParams);
            }
        });
    }

    public void SetVisibility(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.15
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (z) {
                    CWebViewPlugin.this.mWebView.setVisibility(0);
                    CWebViewPlugin.layout.requestFocus();
                    CWebViewPlugin.this.mWebView.requestFocus();
                    return;
                }
                CWebViewPlugin.this.mWebView.setVisibility(8);
            }
        });
    }

    public void SetInteractionEnabled(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.16
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mInteractionEnabled = z;
            }
        });
    }

    public void SetScrollbarsVisibility(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.17
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.setHorizontalScrollBarEnabled(z);
                CWebViewPlugin.this.mWebView.setVerticalScrollBarEnabled(z);
            }
        });
    }

    public void SetAlertDialogEnabled(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.18
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAlertDialogEnabled = z;
            }
        });
    }

    public void SetCameraAccess(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.19
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAllowVideoCapture = z;
            }
        });
    }

    public void SetMicrophoneAccess(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.20
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAllowAudioCapture = z;
            }
        });
    }

    public void SetNetworkAvailable(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.21
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.setNetworkAvailable(z);
            }
        });
    }

    public void Pause() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.22
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.onPause();
                CWebViewPlugin.this.mWebView.pauseTimers();
            }
        });
    }

    public void Resume() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.23
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.onResume();
                CWebViewPlugin.this.mWebView.resumeTimers();
            }
        });
    }

    public void OnApplicationPause(boolean z) {
        this.mPaused = z;
        final Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.24
            @Override // java.lang.Runnable
            public void run() {
                if (!CWebViewPlugin.this.mPaused && CWebViewPlugin.this.mTransactions != null) {
                    for (Pair pair : CWebViewPlugin.this.mTransactions) {
                        CWebViewPlugin cWebViewPlugin = (CWebViewPlugin) pair.second;
                        String str = (String) pair.first;
                        str.hashCode();
                        if (str.equals("remove")) {
                            activity.getFragmentManager().beginTransaction().remove(cWebViewPlugin).commitAllowingStateLoss();
                        } else if (str.equals("add")) {
                            activity.getFragmentManager().beginTransaction().add(0, cWebViewPlugin, "CWebViewPlugin" + CWebViewPlugin.this.mInstanceId).commitAllowingStateLoss();
                        }
                    }
                    CWebViewPlugin.this.mTransactions.clear();
                }
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (CWebViewPlugin.this.mPaused) {
                    CWebViewPlugin.this.mWebView.onPause();
                    if (CWebViewPlugin.this.mWebView.getVisibility() == 0) {
                        CWebViewPlugin.this.mWebView.pauseTimers();
                        return;
                    }
                    return;
                }
                CWebViewPlugin.this.mWebView.onResume();
                CWebViewPlugin.this.mWebView.resumeTimers();
            }
        });
    }

    public void AddCustomHeader(String str, String str2) {
        Hashtable<String, String> hashtable = this.mCustomHeaders;
        if (hashtable == null) {
            return;
        }
        hashtable.put(str, str2);
    }

    public String GetCustomHeaderValue(String str) {
        Hashtable<String, String> hashtable = this.mCustomHeaders;
        if (hashtable != null && hashtable.containsKey(str)) {
            return this.mCustomHeaders.get(str);
        }
        return null;
    }

    public void RemoveCustomHeader(String str) {
        Hashtable<String, String> hashtable = this.mCustomHeaders;
        if (hashtable != null && hashtable.containsKey(str)) {
            this.mCustomHeaders.remove(str);
        }
    }

    public void ClearCustomHeader() {
        Hashtable<String, String> hashtable = this.mCustomHeaders;
        if (hashtable == null) {
            return;
        }
        hashtable.clear();
    }

    public void ClearCookies() {
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
    }

    public void SaveCookies() {
        CookieManager.getInstance().flush();
    }

    public void GetCookies(String str) {
        this.mWebViewPlugin.call("CallOnCookies", CookieManager.getInstance().getCookie(str));
    }

    public void SetCookies(String str, List<String> list) {
        CookieManager cookieManager = CookieManager.getInstance();
        for (String str2 : list) {
            cookieManager.setCookie(str, str2);
        }
        cookieManager.flush();
    }

    public void SetBasicAuthInfo(String str, String str2) {
        this.mBasicAuthUserName = str;
        this.mBasicAuthPassword = str2;
    }

    public void ClearCache(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.25
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.clearCache(z);
            }
        });
    }

    public void SetTextZoom(final int i) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.26
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.getSettings().setTextZoom(i);
            }
        });
    }
}
