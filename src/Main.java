public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        Worker worker = new Worker(listener);
        worker.start();

    }
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    public static class Worker {
        private OnTaskDoneListener callback;
        public Worker(OnTaskDoneListener callback) {
            this.callback = callback;
        }
        public void start() {
            for (int i = 0; i < 100; i++) {
                callback.onDone("Task" + i + " is done");
            }
        }
    }
}