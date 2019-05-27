package com.jumia.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

  @Id
  @Column
  private Long id;
  @Column(length = 50)
  private String name;
  @Column(length = 50)
  private String phone;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(getId(), customer.getId()) &&
        Objects.equals(getName(), customer.getName()) &&
        Objects.equals(getPhone(), customer.getPhone());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPhone());
  }
}
