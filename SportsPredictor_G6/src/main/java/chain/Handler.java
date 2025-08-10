package chain;

public interface Handler { void setNext(Handler h); void handle(Incidente request); }
