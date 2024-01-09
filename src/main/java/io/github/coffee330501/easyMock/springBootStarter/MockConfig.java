package io.github.coffee330501.easyMock.springBootStarter;

import io.github.coffee330501.easyMock.MockManager;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "easy-mock")
public class MockConfig {
    public boolean globalUseMock;

    public boolean isGlobalUseMock() {
        return globalUseMock;
    }

    public void setGlobalUseMock(boolean globalUseMock) {
        this.globalUseMock = globalUseMock;
        if (globalUseMock) MockManager.turnOnMock();
    }
}
