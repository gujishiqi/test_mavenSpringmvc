package com.zc.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bloginfo", schema = "zc_springmvc", catalog = "")
public class BloginfoEntity {
    private int id;
    private String tittle;
    private String content;
    private Date pubDate;
    private UserinfoEntity userinfoByUserid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tittle", nullable = false, length = 100)
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pub_date", nullable = false)
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloginfoEntity that = (BloginfoEntity) o;

        if (id != that.id) return false;
        if (tittle != null ? !tittle.equals(that.tittle) : that.tittle != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tittle != null ? tittle.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    public UserinfoEntity getUserinfoByUserid() {
        return userinfoByUserid;
    }

    public void setUserinfoByUserid(UserinfoEntity userinfoByUserid) {
        this.userinfoByUserid = userinfoByUserid;
    }
}
