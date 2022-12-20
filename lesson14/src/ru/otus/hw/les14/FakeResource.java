package ru.otus.hw.les14;

/**
 * Имитация ресурса
 */
public class FakeResource implements AutoCloseable {

    private final ResourceMonitor monitor;

    /**
     * Открыть ресурс
     */
    public void open() {
        monitor.markAsOpen();
    }

    /**
     * Создать объект работающий с ресурсом
     * @param monitor монитор статуса
     */
    public FakeResource(ResourceMonitor monitor) {
        this.monitor = monitor;
    }

    /**
     * Закрытие ресурса
     */
    //TODO: в  AutoCloseable void close() throws Exception;, вопрос корректно ли без throws
    @Override
    public void close() {
        monitor.markAsClosed();
    }
}

/**
 * Монитор работы ресурса
 */
class ResourceMonitor {
    private boolean resourceState = false;

    /**
     * Пометить ресурс как открытый
     */
    public void markAsOpen() {
        resourceState = true;
    }

    /**
     * Пометить ресурс как закрытый
     */
    public void markAsClosed() {
        resourceState = false;
    }

    /**
     * Посмотреть статус ресурса
     * @return статус ресурса
     */
    public boolean getResourceState() {
        return resourceState;
    }


}
