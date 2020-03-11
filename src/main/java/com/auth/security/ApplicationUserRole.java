package com.auth.security;
import com.google.common.collect.Sets;

import java.util.Set;
/**
 * Created by jyde on 3/10/2020.
 */
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ,
            ApplicationUserPermission.STUDENT_WRITE,
            ApplicationUserPermission.COURSE_READ,
            ApplicationUserPermission.COURSE_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(ApplicationUserPermission.STUDENT_READ,
               ApplicationUserPermission.COURSE_READ
         ));

    private final Set<ApplicationUserPermission>  permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
