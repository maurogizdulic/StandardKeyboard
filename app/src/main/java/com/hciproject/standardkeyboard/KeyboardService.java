package com.hciproject.standardkeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;


public class KeyboardService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyEvent keyEventBackspace = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL);
    private KeyEvent keyEventSpace = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SPACE);
    private KeyEvent keyEventEnter = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
    private KeyboardView keyboardView;


    @Override
    public View onCreateInputView(){
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.multitap_keyboard_layout, null);
        Keyboard keyboard = new Keyboard(this, R.xml.main_keyboard_layout);
        keyboardView.setKeyboard(keyboard);

        keyboardView.setOnKeyboardActionListener(this);

        keyboardView.setPreviewEnabled(false);

        return keyboardView;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int value, int[] keyCodes) {

        if(value == 8){
            InputConnection inputConnection = getCurrentInputConnection();
            inputConnection.sendKeyEvent(keyEventBackspace);
            inputConnection.closeConnection();
        }
        else if(value == 26){
            InputConnection inputConnection = getCurrentInputConnection();
            inputConnection.sendKeyEvent(keyEventEnter);
            inputConnection.closeConnection();
        }
        else {
            InputConnection inputConnection = getCurrentInputConnection();
            inputConnection.commitText(String.valueOf((char) value) , 1);
            inputConnection.closeConnection();
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
