package model;


public class GetBookResponse
{
    private Books[] books;

    public Books[] getBooks ()
    {
        return books;
    }

    public void setBooks (Books[] books)
    {
        this.books = books;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [books = "+books+"]";
    }
}
	
