# Steps in adding entity and repo files

- Make User Entity class
- Make Summary Entity class (task for mentees)
- Make user repo
- Make Summary repo (task for mentees)
- Enable jpa repo in spring boot app


# User.class
``` java
package com.chitkara.bootcamp.books.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user", schema = "userinfo")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;
    
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Summary> summaries;
//    
//    public List<Summary> getSummaries() {
//        return summaries;
//    }
//
//    public void setSummaries(List<Summary> summaries) {
//        this.summaries = summaries;
//    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


```

# Summary class

```java
package com.chitkara.bootcamp.books.entities; 

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "summary", schema = "books")
public class Summary implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "summary")
    private Long summaryId;

    @Column(name = "bookname", nullable = false)
    private String bookname;

    @Column(name = "summary_text", nullable = false)
    private String summaryText;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    // Getters and Setters
    public Long getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(Long summaryId) {
        this.summaryId = summaryId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

```

# UserRepo

```java
package com.chitkara.bootcamp.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitkara.bootcamp.books.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}



```

#Summary repo

``` java 
package com.chitkara.bootcamp.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitkara.bootcamp.books.entities.Summary;

@Repository
public interface SummaryRepo extends JpaRepository<Summary, Long> {

}



```


