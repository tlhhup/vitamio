# vitamio
vitamio初探
简单的使用vitamio框架做的视频处理，主要是学习下vitamio的使用。


使用：
1、在activity中必须添加Vitamio.isInitialized(getApplicationContext());用于检测vitamio使用初始化
2、在android清单文件中添加以下配置
          <activity
            android:name="io.vov.vitamio.activity.InitActivity"
            android:configChanges="orientation|screenSize|smallestScreenSize|keyboard|keyboardHidden|navigation"
            android:launchMode="singleTop"
            android:theme="@android:style/Theme.NoTitleBar"
            android:windowSoftInputMode="stateAlwaysHidden" />
