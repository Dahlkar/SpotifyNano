package util;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.win32.W32APIOptions;

public interface MyUser32 extends User32 {
	MyUser32 INSTANCE = (MyUser32)Native.loadLibrary("user32", MyUser32.class, W32APIOptions.DEFAULT_OPTIONS);
    LRESULT SendMessage(HWND hWnd, int Msg, WPARAM wParam, LPARAM lParam);
}
