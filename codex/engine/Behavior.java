package codex.engine;
public abstract class Behavior{
    public abstract void init(Engine eng, GameObject parent);
    public abstract void run(Engine eng, GameObject parent);
}