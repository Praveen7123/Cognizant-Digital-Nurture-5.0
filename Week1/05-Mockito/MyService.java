// Service under test. It depends on ExternalApi (injected via constructor),
// so in tests we can pass a MOCK instead of the real API.
public class MyService {

    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
