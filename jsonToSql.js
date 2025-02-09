import { readFileSync } from "fs";
import mysql from "mysql2/promise";

const connection = await mysql.createConnection({
  host:     "localhost",
  user:     USER_NAME,
  password: PASSWORD,
  database: DATABASE_NAME,
});

async function addAuthor(fname, lname, dob, dod, genre) {
  if (dod != null)
    await connection.query(`
    insert into author (
      firstName,
      lastName,
      dateOfBirth,
      dateOfDeath,
      genre
    ) values (
      "${fname}",
      "${lname}",
      "${dob}",
      "${dod}",
      "${genre}"
    )
    `);
  else
    await connection.query(`
    insert into author (
      firstName,
      lastName,
      dateOfBirth,
      genre
    ) values (
      "${fname}",
      "${lname}",
      "${dob}",
      "${genre}"
    )
    `);
}

async function getAuthorIdByFullName(fullName) {
  return await connection
    .query(
      `
      select id from author
      where "${fullName}" like concat(firstName, '%', lastName)
      `
    )
    .then(([result]) => {
      console.log(fullName);
      return result[0].id;
    });
}

async function addBook(title, author, year) {
  const authorId = await getAuthorIdByFullName(author);
  await connection.query(`
    insert into book (
      title,
      author,
      yearPublished
    ) values (
      "${title}",
      ${authorId},
      ${year}
    )
    `);
}

async function addAuthors() {
  const promises = [];
  for (const author of JSON.parse(readFileSync("authors.json"))) {
    promises.push(
      addAuthor(
        author["first_name"],
        author["last_name"],
        author["date_of_birth"],
        author["date_of_death"],
        author["genre"]
      )
    );
  }
  await Promise.all(promises);
}

async function addBooks() {
  const promises = [];
  for (const book of JSON.parse(readFileSync("books.json"))) {
    promises.push(
      addBook(book["title"], book["author"], book["year_published"])
    );
  }
  await Promise.all(promises);
}

await addAuthors();
await addBooks();

process.exit();
