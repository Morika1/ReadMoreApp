package com.example.readmorelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.textview.MaterialTextView;

public class ReadMoreView extends LinearLayoutCompat {

    private final static int MAX_LINES = 5000;
    private String showLess;
    private String readMore;
    private MaterialTextView view_LBL_destination;
    private MaterialTextView view_LBL_expandcollapse;
    private int numOfLines_collapsed = 2;
    private boolean hidden = true;
    private String text;
    private Float textSize;
    private int textColor;
    private boolean isInitiated = false;


    public ReadMoreView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ReadMoreView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(!isInitiated){
            isInitiated = true;
            setExpandCollapseVisibility();
            if(view_LBL_expandcollapse.getVisibility() == View.VISIBLE){
                view_LBL_expandcollapse.setText(readMore);
                view_LBL_destination.setMaxLines(numOfLines_collapsed);
            }
        }
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ReadMoreView, 0, 0);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.read_more_view, this, true);

        findViews(view);
        initViews();

        showLess = ta.getString(R.styleable.ReadMoreView_showLessText);
        readMore = ta.getString(R.styleable.ReadMoreView_readMoreText);

        numOfLines_collapsed = ta.getResourceId(R.styleable.ReadMoreView_collapsedLines, 2);
        text = ta.getString(R.styleable.ReadMoreView_text);
        textSize = ta.getFloat(R.styleable.ReadMoreView_textSize, 11);
        textColor = ta.getColor(R.styleable.ReadMoreView_textColor,Color.GRAY);

        ta.recycle();

        showLess = context.getString(R.string.show_less);
        readMore = context.getString(R.string.read_more);

        view_LBL_destination.setText(text);
        view_LBL_destination.setMaxLines(numOfLines_collapsed);
        view_LBL_destination.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        view_LBL_destination.setTextColor(textColor);

    }

    private void initViews() {

        view_LBL_expandcollapse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checkHideStatus();
            }
        });
    }

    private void checkHideStatus(){

        if(hidden){ // means that until now text was hidden and read more was pressed
            view_LBL_destination.setMaxLines(MAX_LINES);
            view_LBL_expandcollapse.setText(showLess);
            hidden = false;
        }
        else{
            view_LBL_destination.setMaxLines(numOfLines_collapsed);
            view_LBL_expandcollapse.setText(readMore);
            hidden = true;
        }
    }

    private void setExpandCollapseVisibility(){

        if(view_LBL_destination.getLineCount() <= numOfLines_collapsed){
            view_LBL_expandcollapse.setVisibility(View.INVISIBLE);
        }
        else
            view_LBL_expandcollapse.setVisibility(View.VISIBLE);
    }

    private void findViews(View view) {
        view_LBL_destination = view.findViewById(R.id.view_LBL_destination);
        view_LBL_expandcollapse = view.findViewById(R.id.view_LBL_expandcollapse);
    }

    public void setText(String text){
        this.text = text;
        view_LBL_destination.setText(text);
        setExpandCollapseVisibility();
        if(view_LBL_expandcollapse.getVisibility() == View.VISIBLE){
            view_LBL_expandcollapse.setText(readMore);
            view_LBL_destination.setMaxLines(numOfLines_collapsed);
        }
    }
}
