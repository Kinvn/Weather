package com.kinvn.weather.weather.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kinvn.weather.weather.common.utils.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kinvn on 2018/4/9.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class FoldLineView extends View {
    private List<String> xList = new ArrayList<>();
    private List<Integer> yList = new ArrayList<>();
    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private int mColor;

    public FoldLineView(Context context) {
        this(context, null);
    }

    public FoldLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FoldLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(Util.dip2px(getContext(), 1));
        mPaint.setTextSize(Util.dip2px(getContext(), 10));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth() - getPaddingStart() - getPaddingEnd();
        mHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (xList == null || yList == null || xList.size() == 0 || yList.size() == 0) {
            return;
        }
        int interval = mWidth / (xList.size() - 1);
        float unit = mHeight * (3f / 4) / Collections.max(yList);
        for (int i = 0; i < yList.size() - 1; i++) {
            canvas.drawCircle(i * interval + getPaddingStart(), mHeight - yList.get(i) * unit,
                    Util.dip2px(getContext(), 3), mPaint);
            canvas.drawLine(i * interval + getPaddingStart(), mHeight - yList.get(i) * unit,
                    (i + 1) * interval + getPaddingStart(), mHeight - yList.get(i + 1) * unit,
                    mPaint);
            String tmp = String.valueOf(yList.get(i)) + "℃";
            canvas.drawText(tmp, i * interval + getPaddingStart() - mPaint.measureText(tmp) / 2,
                    mHeight - yList.get(i) * unit - Util.dip2px(getContext(), 10), mPaint);
        }
        canvas.drawCircle(mWidth + getPaddingStart(), mHeight - yList.get(yList.size() - 1) * unit,
                Util.dip2px(getContext(), 3), mPaint);
        String tmp = String.valueOf(yList.get(yList.size() - 1)) + "℃";
        canvas.drawText(tmp, mWidth + getPaddingStart() - mPaint.measureText(tmp) / 2,
                mHeight - yList.get(yList.size() - 1) * unit - Util.dip2px(getContext(), 10),
                mPaint);
    }

    public void setXList(List<String> xList) {
        this.xList = xList;
    }

    public void setYList(List<Integer> yList) {
        this.yList = yList;
    }
}
