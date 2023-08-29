create table BOOK_AUTHOR(
    authorId varchar(255) not null references AUTHOR(id),
    bookId varchar(255) not null references BOOK(ISBN)
)