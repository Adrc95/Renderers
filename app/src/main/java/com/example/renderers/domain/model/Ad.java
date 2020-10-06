package com.example.renderers.domain.model;

public class Ad extends Publication {

    private String titleHeader;
    private boolean header;

    public Ad(){
        super();
    }

    public Ad(int id, String photo, String title, String titleHeader, boolean header) {
        super(id, photo, title);
        this.titleHeader = titleHeader;
        this.header = header;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ad) {
            Ad other = (Ad) obj;
            return titleHeader.equals(other.titleHeader)
                    && header == other.header;
        } else {
            return false;
        }
    }

    public String getTitleHeader() {
        return titleHeader;
    }

    public void setTitleHeader(String titleHeader) {
        this.titleHeader = titleHeader;
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }
}
