package info.basic;

public class WorkService {
    WorkManager workManager;

    public void setWorkManager(WorkManager workManager) {
        this.workManager = workManager;
    }

    public void asWork() {
        System.out.println(workManager.doIt());
    }
}
