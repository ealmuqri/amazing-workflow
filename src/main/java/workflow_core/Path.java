package workflow_core;

public class Path {
    private Step source;
    private Step destination;

    public Path(Step source, Step destination) {
        this.source = source;
        this.destination = destination;
    }

    public Step getSource() {
        return source;
    }

    public void setSource(Step source) {
        this.source = source;
    }

    public Step getDestination() {
        return destination;
    }

    public void setDestination(Step destination) {
        this.destination = destination;
    }
}
