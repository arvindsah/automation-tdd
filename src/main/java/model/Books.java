package model;

public class Books
{
    private String website;

    private String pages;

    private String subTitle;

    private String author;

    private String isbn;

    private String publisher;

    private String description;

    private String title;

    private String publish_date;

    public String getWebsite ()
    {
        return website;
    }

    public void setWebsite (String website)
    {
        this.website = website;
    }

    public String getPages ()
    {
        return pages;
    }

    public void setPages (String pages)
    {
        this.pages = pages;
    }

    public String getSubTitle ()
    {
        return subTitle;
    }

    public void setSubTitle (String subTitle)
    {
        this.subTitle = subTitle;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getIsbn ()
    {
        return isbn;
    }

    public void setIsbn (String isbn)
    {
        this.isbn = isbn;
    }

    public String getPublisher ()
    {
        return publisher;
    }

    public void setPublisher (String publisher)
    {
        this.publisher = publisher;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getPublish_date ()
    {
        return publish_date;
    }

    public void setPublish_date (String publish_date)
    {
        this.publish_date = publish_date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [website = "+website+", pages = "+pages+", subTitle = "+subTitle+", author = "+author+", isbn = "+isbn+", publisher = "+publisher+", description = "+description+", title = "+title+", publish_date = "+publish_date+"]";
    }
}
			
			