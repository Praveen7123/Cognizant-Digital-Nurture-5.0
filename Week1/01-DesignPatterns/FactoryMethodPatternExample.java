interface Document{
    void open();
}


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

abstract class DocumentFactory{
    abstract Document createDocument();
}

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


