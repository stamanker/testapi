package ua.od.maxz.testapi;

import java.util.Date;

/**
 * User: maxz
 * Date: 26.04.2016
 */
class Reseller {
    public int id;
    public String first_name;
    public String last_name;
    public String email;
    public String login;
    public String slug;
    public Date created_at;
    public Date updated_at;

    public Reseller() {
    }

    public Reseller(int id, String first_name, String last_name, String email, String login, String slug, Date created_at, Date updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.login = login;
        this.slug = slug;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Reseller{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", slug='" + slug + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}