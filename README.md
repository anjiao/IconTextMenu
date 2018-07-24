# 项目描述
安卓自定义文字和图标按钮，适合放在MainActivity底部，仅作为个人作为教学示例演示

# 使用说明

1、gradle引入
 ```java
    compile 'com.joe.tabmenu:tabmenu:1.0.0'
 ```
 
2、布局文件使用

 ```java
 <com.joe.tabmenu.IconWithTextMenu
   android:id="@+id/btm_menu_me"
   android:layout_width="0dp"
   android:layout_height="match_parent"
   android:layout_weight="1"
   app:menu_icon="@mipmap/me_yf"
   app:menu_icon_height="21dp"
   app:menu_icon_width="21dp"
   app:menu_text_textColor="@color/main_gray"
   app:menu_text_textSize="10dp"
   app:menu_title="我的" />
 ```