package com.joe.tabmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by joe.
 */
public class IconWithTextMenu extends LinearLayout {

    private ImageView icon;
    private TextView title;


    public IconWithTextMenu(Context context) {
        super(context);
    }

    public IconWithTextMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.icon_text_menu_lay, this, true);
        icon = (ImageView) this.findViewById(R.id.menu_icon);
        title = (TextView) this.findViewById(R.id.menu_title);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.IconWithText);
        int num = array.getIndexCount();
        LayoutParams lps = (LayoutParams) icon.getLayoutParams();
        for (int i = 0; i < num; i++) {
            int attr = array.getIndex(i);
            if (attr == R.styleable.IconWithText_menu_icon) {
                Drawable preDrawable = icon.getDrawable();
                BitmapDrawable drawable = (BitmapDrawable) array.getDrawable(attr);
                icon.setImageDrawable(drawable);
                if (preDrawable != null) {
                    preDrawable = null;
                }
            } else if (attr == R.styleable.IconWithText_menu_icon_height) {
                lps.height = (int) array.getDimension(attr, -2);
            } else if (attr == R.styleable.IconWithText_menu_icon_width) {
                lps.width = (int) array.getDimension(attr, -1);
                icon.setLayoutParams(lps);
            } else if (attr == R.styleable.IconWithText_menu_icon_scaleType) {
                int scaleType = array.getInt(attr, 1);
                switch (scaleType) {
                    case 0:
                        icon.setScaleType(ImageView.ScaleType.MATRIX);
                        break;
                    case 1:
                        icon.setScaleType(ImageView.ScaleType.FIT_XY);
                        break;
                    case 2:
                        icon.setScaleType(ImageView.ScaleType.FIT_START);
                        break;
                    case 3:
                        icon.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        break;
                    case 4:
                        icon.setScaleType(ImageView.ScaleType.FIT_END);
                        break;
                    case 5:
                        icon.setScaleType(ImageView.ScaleType.CENTER);
                        break;
                    case 6:
                        icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        break;
                    case 7:
                        icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        break;
                }
            } else if (attr == R.styleable.IconWithText_menu_title) {
                title.setText(array.getString(attr));
            } else if (attr == R.styleable.IconWithText_menu_text_textColor) {
                title.setTextColor(array.getColor(attr, Color.WHITE));
            } else if (attr == R.styleable.IconWithText_menu_text_textSize) {//System.out.println("textsize:"+array.getDimension(attr, 0));
                title.setTextSize(TypedValue.COMPLEX_UNIT_PX, array.getDimension(attr, 0));
            } else if (attr == R.styleable.IconWithText_menu_text_height) {
                title.setHeight((int) array.getDimension(attr, -1));
            } else if (attr == R.styleable.IconWithText_menu_text_width) {
                title.setWidth((int) array.getDimension(attr, -2));
            }
        }
        icon.setLayoutParams(lps);
        array.recycle();
    }

    public void updateIconWithText(int imgRes, int textColorRes) {
        Drawable preDrawable = icon.getDrawable();
        icon.setImageResource(imgRes);
        title.setTextColor(getContext().getResources().getColor(textColorRes));
        preDrawable = null;
    }

    public ImageView getIcon() {
        return icon;
    }

    public TextView getTitle() {
        return title;
    }


}
