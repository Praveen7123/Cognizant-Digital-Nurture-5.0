interface Document{
    void open();
}

//2.Creating the interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.

class WordDocument implements Document{
    public void open(){
        System.out.println("Opening the word document...");
         try {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e){
            System.out.println("Interrupted try again later");
        }
        System.out.println("Word document opened");
    }
}

class PdfDocument implements Document{
     public void open(){
        System.out.println("Opening the PDF document...");
        try {
            Thread.sleep(2000);
            //I just used this to delay the opening just like our application opening way...
        } 
        catch (InterruptedException e){
            System.out.println("Interrupted try again later");
        }
        System.out.println("Pdf document opened");
    }
}


class ExcelDocument implements Document{
     public void open(){
        System.out.println("Opening the Excel document...");
         try {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e){
            System.out.println("Interrupted try again later");
        }
        System.out.println("Excel document opened");
    }
}

//4.Create an abstract class DocumentFactory with a method createDocument().

abstract class DocumentFactory{
    abstract Document createDocument();
}

//3.Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.

class WordFactory extends DocumentFactory{
    Document createDocument(){
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory{
    Document createDocument(){
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory{
    Document createDocument(){
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample{
    public static void main(String[] args){
        DocumentFactory factory = new WordFactory();
        Document doc = factory.createDocument();
        doc.open();

        DocumentFactory factory2 = new PdfFactory();
        Document pdfDoc = factory2.createDocument();
        pdfDoc.open();

        DocumentFactory factory3 = new PdfFactory();
        Document ExcelDoc = factory3.createDocument();
        ExcelDoc.open();


    }
}


