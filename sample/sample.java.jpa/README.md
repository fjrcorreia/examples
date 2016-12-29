

Persistable Types
====



// This annotation specifies to declare the class as entity or a table.
@Entity 	

// This annotation specifies to declare table name.
@Table 	


Entity Fields
---
Attributes of a class are not persisted if:
  * static, final, transient modifier
  * @Transient annotation



<details>
<summary>Java Primitive Types</summary>
  * boolean, byte, short, char, int, long, float and double.
  * Boolean, Byte, Short, Character, Integer, Long, Float and Double.
  * java.math.BigInteger, java.math.BigDecimal.
  * java.lang.String.
  * Temporal Data Types: java.util.Date, java.util.Calendar,
  * java.sql.Date, java.sql.Time, java.sql.Timestamp.
</details>

// Date, Time and Date Time fields
@Temporal (
   TemporalType.{
     DATE, // (e.g. 2010-12-31)
     TIME, // (e.g. 23:59:59)
     TIMESTAMP // (e.g. 2010-12-31 23:59:59)
    }
  )



// This annotation specifies the properties of class or an entity whose value
// instance of an embeddable class.
@Embedded

// This annotation specifies the property which in not persistent i.e. the value
// is never stored into database.
@Transient

// This annotation is used to specify column or attribute for persistence property.
@Column 	





Entity Relations
---

// This annotation is used to define a many-to-one relationship between the join Tables.
@ManyToOne 	

// This annotation is used to define a one-to-one relationship between the join Tables.
@OneToOne

// This annotation is used to define a many-to-many relationship between the join Tables.
// Used on Collections and Maps
@ManyToMany

// This annotation is used to define a one-to-many relationship between the join Tables.
// Used on Collections and Maps
@OneToMany 	

// for any other persistable type
// This annotation specifies non constraint fields explicitly
@Basic

//
FetchType {
  EAGER, // Require the value to be eagerly fetched
  LAZY // Hint for the JPA provider
}

// Used to specify an access type to be applied to an entity class, mapped superclass,
// or embeddable class, or to a specific attribute of such a class.
@Access





Primary Key
---
// This annotation specifies the property, use for identity (primary key of a table) of the class.
@Id 	




Generated Values
---
// This annotation specifies, how the identity attribute can be initialized such
// as Automatic, manual, or value taken from sequence table.
@GeneratedValue 	

// This annotation is used to define the value for the property which is specified
// in @GeneratedValue annotation. It creates a sequence.
@SequenceGenerator

// This annotation is used to specify the value generator for property specified
// in @GeneratedValue annotation. It creates a table for value generation.
@TableGenerator




Index Definition
---
// Annotation for a database index. Used for database schema generation to create
// indexes. Corresponds to the xml element "index".
@Index

// Used for database schema generation to create unique constraints. Also used
// to reorder database operations when flushing changes to avoid unique constraint
// violations.
@Unique




// This type of annotation is used to set the access type. If you set
// @AccessType(FIELD) then Field wise access will occur.
// If you set @AccessType(PROPERTY) then Property wise assess will occur.
@AccessType


// This annotation is used to specify an entity association or entity collection. This is used in many- to-one and one-to-many associations.
@JoinColumn 	

// This annotation is used to specify the field, unique constraint for primary or secondary table.
@UniqueConstraint 	

// This annotation references the name of a column in the SQL query using select clause.
@ColumnResult 	


// This annotation is used for specifying list of named queries.
@NamedQueries

// This annotation is used for specifying a Query using static name.
@NamedQuery 	


Special fields
---
// Defines the version of the object on the database useful for the optimistic lock
@Version



References
---
  * [ObjectDB 2.6 Developer's Guide](http://www.objectdb.com/java/jpa)
