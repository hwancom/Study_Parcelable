package com.example.administrator.study_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* (1) Java Class를 추가하고 */
public class BookData implements Parcelable {

    /* (3) 데이터를 변수를 선언해서 집어넣는다. */
    String title;
    String author;
    String publisher;
    String isbn;
    String description;
    int price;
    String photoUrl;

    /* (4) 생성자를 만든다. Generate > Constructor 를 통해 입력 가능 */
    public BookData(String title, String author, String publisher, String isbn, String description, int price, String photoUrl) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
        this.price = price;
        this.photoUrl = photoUrl;
    }

    /* (2) Generate > Override Methods > 아래 두가지 메소드를 추가한다. */
    @Override
    public int describeContents() {
        return 0;
    }

    /* (5) 실제 오브젝트 serialization/flattening을 하는 메소드.
    * 오브젝트의 각 엘리먼트를 각각 parcel해줘야 한다. */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(publisher);
        parcel.writeString(isbn);
        parcel.writeString(description);
        parcel.writeInt(price);
        parcel.writeString(photoUrl);
    }

    /* (7) 모든 parcel된 데이터를 복구하는 생성자를 정의해 줘야만 한다.
    * 주의할것은 writeToParcel() 메소드에서 기록한 순서와 동일하게 복구해야만 한다. */
    public BookData(Parcel in) {
        title = in.readString();
        author = in.readString();
        publisher = in.readString();
        isbn = in.readString();
        description = in.readString();
        price = in.readInt();
        photoUrl = in.readString();
    }

    /* (6) Parcel에서 데이터를 un-marshal/de-serialize하는 단계를 추가해줘야 한다.
    * 그러기 위해서 Parcelable.Creator 타입의 CREATOR라는 변수를 정의해야 한다. */
    public static final Parcelable.Creator<BookData> CREATOR = new Parcelable.Creator<BookData>() {
        public BookData createFromParcel(Parcel in) {
            return new BookData(in);
        }

        public BookData[] newArray(int size) {
            return new BookData[size];
        }
    };
}
