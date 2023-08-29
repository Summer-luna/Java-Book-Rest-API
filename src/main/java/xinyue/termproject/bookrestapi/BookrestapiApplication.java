/**
 * Book Rest API
 * 	provides an interface to allow font-end to add, edit, delete book from database.
 * Author: Xinyue Chen
 * Date: 4/30/2023
 * Class: MET 622
 * Description:
 * 	This program is to build a Restful API to allow front-end to add, edit, and delete books from database.
 * 	It stores a list of authors in HashSet Data Structure.
 * Assumption:
 * 	When any client updates, deletes, or creates a book, other clients can not do operations in the database.
 * 	Clients can get book data from the database at the same time.
 *
 */
package xinyue.termproject.bookrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookrestapiApplication {

	/**
	 * main method and the entry of the program.
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookrestapiApplication.class, args);
	}

}
