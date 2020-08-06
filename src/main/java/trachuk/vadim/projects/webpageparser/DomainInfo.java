package trachuk.vadim.projects.webpageparser;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.URL;

public class DomainInfo {
    private URL domainUrl1;
    private InetAddress domainIp;//
    private boolean pingHost;//
    private long contentSize; //сколько байт HTML скачано//
    private String dnsName;//
    private boolean isWrongUrl;
    private FileOutputStream saveContent;


    public int getPort() {
        return port;
    }

    private int port;
//    public FileOutputStream getSaveContent() { return saveContent; }

    public URL getDomainUrl() {
        return domainUrl1;
    }

    public InetAddress getDomainIp() {
        return domainIp;
    }

    public boolean isPingHost() {
        return pingHost;
    }

    public long getContentSize() {
        return contentSize;
    }

    public String getDnsName() {
        return dnsName;
    }

    public boolean isWrongUrl() {
        return isWrongUrl;
    }


    public static class Builder {
        private DomainInfo newDomainInfo;


        public Builder() {
            newDomainInfo = new DomainInfo();
        }

        public Builder withDomainUrl(URL url) {
            newDomainInfo.domainUrl1 = url;
            return this;
        }


        public Builder withDomainIp(InetAddress domainIp) {
            newDomainInfo.domainIp = domainIp;
            return this;
        }

        public Builder withIsPortAvailable(boolean isPortAvailable) {
            newDomainInfo.pingHost = isPortAvailable;
            return this;
        }

        public Builder withContentSize(long contentSize) {
            newDomainInfo.contentSize = contentSize;
            return this;
        }

        public DomainInfo build() {
            return newDomainInfo;
        }

        public Builder withDomainDNSName(String dnsName) {
            newDomainInfo.dnsName = dnsName;
            return this;
        }

        public Builder withIsWrongUrl(boolean isWrongUrl) {
            newDomainInfo.isWrongUrl = isWrongUrl;
            return this;
        }

        public Builder withPort(int port) {
            newDomainInfo.port = port;
            return this;
        }
    }

    @Override
    public String toString() {
        return "DomainInfo{" +
                "domainUrl1=" + domainUrl1 +
                ", domainIp=" + domainIp +
                ", pingHost=" + pingHost +
                ", contentSize=" + contentSize +
                ", dnsName='" + dnsName + '\'' +
                ", isWrongUrl=" + isWrongUrl +
//                ", saveContent=" + saveContent +
                ", port=" + port +
                '}';
    }
//сделать Builder for DomainInfo;
}
