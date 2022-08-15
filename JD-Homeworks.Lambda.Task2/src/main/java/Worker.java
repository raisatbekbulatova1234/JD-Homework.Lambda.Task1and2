class Main {

    public static class Worker extends Main {
        private OnTaskDoneListener callback;
        private OnTaskErrorListener errorCallback;

        public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
            this.callback = callback;
            this.errorCallback = errorCallback;
        }

        public void start() {
            for (int i = 0; i < 100; i++) {
                if (i == 33) {
                    errorCallback.onError("Task " + i + " !!!ERROR!!! ");
                    i++;
                }
                callback.onDone("Task " + i + " is done");

            }
        }
    }

    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener listener1 = System.out::println;

        Worker worker = new Worker(listener, listener1);
        worker.start();
    }
}