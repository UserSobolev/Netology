import java.util.function.Supplier;

public class Worker {


    @FunctionalInterface
    interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 35; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " is error");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
