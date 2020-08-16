package com.xaron.equilinoxmodded.framework;

import org.lwjgl.opengl.Display;

import toolbox.MyKeyboard;
import toolbox.MyMouse;

public final class Input {
	
	private Input() {}
	
	public static boolean isKeyDown(int key) {
		return MyKeyboard.getKeyboard().isKeyDown(key);
	}
	
	public static boolean keyDown(int key) {
		return MyKeyboard.getKeyboard().keyDownEventOccurred(key);
	}
	
	public static boolean isKeyUp(int key) {
		return MyKeyboard.getKeyboard().isKeyDown(key);
	}
	
	public static boolean keyUp(int key) {
		return MyKeyboard.getKeyboard().keyUpEventOccurred(key);
	}
	
	public static void blockKeyboard() {
		MyKeyboard.getKeyboard().block(true);
	}
	
	public static void unblockKeyboard() {
		MyKeyboard.getKeyboard().block(false);
	}
	
	public static boolean isLeftClick() {
		return MyMouse.getActiveMouse().isLeftClick();
	}
	
	public static boolean isRightClick() {
		return MyMouse.getActiveMouse().isRightClick();
	}
	
	public static boolean isLeftButtonDown() {
		return MyMouse.getActiveMouse().isLeftButtonDown();
	}
	
	public static boolean isRightButtonDown() {
		return MyMouse.getActiveMouse().isRightButtonDown();
	}
	
	public static boolean isLeftButtonRelease() {
		return MyMouse.getActiveMouse().isLeftClickRelease();
	}
	
	public static boolean isRightButtonRelease() {
		return MyMouse.getActiveMouse().isRightClickRelease();
	}
	
	public static boolean isMiddleClick() {
		return MyMouse.getActiveMouse().isMiddleClick();
	}
	
	public static boolean isMiddleButtonRelease() {
		return MyMouse.getActiveMouse().isMiddleClickRelease();
	}
	
	public static boolean isMiddleButtonDown() {
		return MyMouse.getActiveMouse().isMouseWheelDown();
	}
	
	public static boolean isShortRightClick() {
		return MyMouse.getActiveMouse().shortRightClickOccurred();
	}
	
	public static boolean isShortMiddleClick() {
		return MyMouse.getActiveMouse().shortMiddleClickOccurred();
	}
	
	public static int getMouseX() {
		return (int)(MyMouse.getActiveMouse().getX() * Display.getWidth());
	}
	
	public static int getMouseY() {
		return (int)(MyMouse.getActiveMouse().getY() * Display.getHeight());
	}
	
	public static float getMouseXPercent() {
		return MyMouse.getActiveMouse().getX();
	}
	
	public static float getMouseYPercent() {
		return MyMouse.getActiveMouse().getY();
	}
	
	public static int getMouseXChange() {
		return MyMouse.getActiveMouse().getDX();
	}
	
	public static int getMouseYChange() {
		return MyMouse.getActiveMouse().getDY();
	}
	
	public static int getMouseWheel() {
		return MyMouse.getActiveMouse().getDWheel();
	}
}
