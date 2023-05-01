package com.turkcell.service.impl;

import com.turkcell.service.Logger;

public class FileLoggerImpl implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message + ", File logger ile loglandı.");
    }
}
