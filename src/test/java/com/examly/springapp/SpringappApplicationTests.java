package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

//DAY 3 
@Autowired
    private MockMvc mockMvc;


@Test
@Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
	@Order(2)

    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
	@Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
	@Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }  


	//Day 4 Testcases

	@Test
	@Order(5)
    void Day4_test_TaskModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Task.java").isFile());
    }

	@Test
	@Order(6)
    void Day4_test_UserModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/User.java").isFile());
    }

	@Test
	@Order(7)

    void Day4_test_TaskStatusLog_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/TaskStatusLog.java").isFile());
    }

	@Test
	@Order(8)
    void Day4_test_TaskAssignment_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/TaskAssignment.java").isFile());
    }

	@Test
	@Order(9)
    void Day4_test_Comment_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Comment.java").isFile());
    }

@Test
@Order(10)
void Day4_test_User_Has_Entity_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.model.User");
        Class<?> annotation = Class.forName("jakarta.persistence.Entity");

        assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Entity annotation is missing on User class");

    } catch (ClassNotFoundException e) {
        fail("❌ User class not found.");
    } catch (Exception e) {
        fail("❌ Unable to check @Entity annotation on User.");
    }
}


	//Day 5 Tetscases
	@Test
	@Order(11)

    void Day5_testTaskRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/TaskRepository.java").isFile());
    }

	@Test
	@Order(12)
    void Day5_testUserRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/UserRepository.java").isFile());
    }

	@Test
	@Order(13)
    void Day5_testTaskStatusLogRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/TaskStatusLogRepository.java").isFile());
    }


	@Test
	@Order(14)
    void Day5_testTaskAssignmentRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/TaskAssignmentRepository.java").isFile());
    }

	@Test
	@Order(15)
    void Day5_testCommentRepository_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/CommentRepository.java").isFile());
    }


	@Test
	@Order(16)
    void Day5_test_UserRepo_Has_Repository_Annotation() {
        try {
            // Load UserRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.UserRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on ProductRepo class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ UserRepository class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on UserRepository.");
        }
    }


	@Test
	@Order(17)
    void Day5_test_TaskRepository_Has_Repository_Annotation() {
        try {
            // Load UserRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.TaskRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on TaskRepository class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ TaskRepository class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on TaskRepository.");
        }
    }


	@Test
	@Order(18)
    void Day5_test_TaskStatusLogRepository_Has_Repository_Annotation() {
        try {
            // Load UserRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.TaskStatusLogRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on TaskStatusLogRepository class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ TaskStatusLog class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on TaskStatusLogRepository.");
        }
    }


	@Test
	@Order(19)
    void Day5_test_TaskAssignmentRepository_Has_Repository_Annotation() {
        try {
            // Load UserRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.TaskAssignmentRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on TaskAssignmentRepository class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ TaskAssignmentRepository class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on TaskAssignmentRepository.");
        }
    }


	@Test
	@Order(20)
    void Day5_test_CommentRepository_Has_Repository_Annotation() {
        try {
            // Load CommentRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.repository.CommentRepository");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @Repository annotation is missing on CommentRepository class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ CommentRepository class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on CommentRepository.");
        }
    }




	@Test
	@Order(21)
    void Day6_test_TaskController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/TaskController.java").isFile());
    }


	@Test
	@Order(22)
    void Day6_test_UserController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/UserController.java").isFile());
    }

	@Test
	@Order(23)
    void Day6_test_TaskStatusLogController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/TaskStatusLogController.java").isFile());
    }

	
	@Test
	@Order(24)
    void Day6_test_TaskAssignmentController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/TaskAssignmentController.java").isFile());
    }

	@Test
	@Order(25)
    void Day6_test_CommentController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/CommentController.java").isFile());
    }


	@Test
	@Order(26)
    void Day6_test_TaskController_Has_RestController_Annotation() {
        try {
            // Load UserRepository class dynamically
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");

            // Load @Repository annotation dynamically
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");



            // Check if annotation is present
            assertTrue(
                clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                "❌ @RestController annotation is missing on TaskController class"
            );

        } catch (ClassNotFoundException e) {
            fail("❌ TaskStatusLog class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RestController annotation on TaskController.");
        }
    }

	
@Test
@Order(27)
void Day6_test_UserController_Has_RestController_Annotation() {
    try {
        Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
        Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

        assertTrue(
            clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
            "❌ @RestController annotation is missing on UserController class"
        );

    } catch (ClassNotFoundException e) {
        fail("❌ UserController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @RestController annotation on UserController.");
    }
}


@Test
@Order(28)

void Day6_test_TaskController_Has_PostMapping() {
    try {
        // Load the controller class
        Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");

        // Load @PostMapping annotation dynamically
        Class<?> postMapping = Class.forName("org.springframework.web.bind.annotation.PostMapping");

        boolean found = false;

        // Check if any method has @PostMapping
        for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent((Class<? extends Annotation>) postMapping)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "❌ No method with @PostMapping found in TaskController");

    } catch (ClassNotFoundException e) {
        fail("❌ TaskController class not found.");
    } catch (Exception e) {
        fail("❌ Unable to verify @PostMapping annotation in TaskController.");
    }
}


@Test
@Order(29)

    void Day6_test_TaskController_Has_GetMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");
            Class<?> getMapping = Class.forName("org.springframework.web.bind.annotation.GetMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) getMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @GetMapping method found in TaskController");

        } catch (ClassNotFoundException e) {
            fail("❌ TaskController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @GetMapping in TaskController.");
        }
    }


	@Test
	@Order(30)

    void Day6_test_TaskController_Has_PutMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");
            Class<?> putMapping = Class.forName("org.springframework.web.bind.annotation.PutMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) putMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @PutMapping method found in TaskController");

        } catch (ClassNotFoundException e) {
            fail("❌ TaskController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PutMapping in TaskController.");
        }
    }

	@Test
	@Order(31)

    void Day6_test_TaskController_Has_DeleteMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");
            Class<?> deleteMapping = Class.forName("org.springframework.web.bind.annotation.DeleteMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) deleteMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @DeleteMapping method found in TaskController");

        } catch (ClassNotFoundException e) {
            fail("❌ TaskController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @DeleteMapping in TaskController.");
        }
    }




// @Test
// @Order(33)
// public void Day6_testCreateTask_NoBody_StatusBadRequest() throws Exception {

//     mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
//             .contentType(MediaType.APPLICATION_JSON))
//             .andExpect(MockMvcResultMatchers.status().isBadRequest());
// }


@Test
@Order(32)
public void Day6_testGetAllUsers_StatusNoCotent() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
            .andExpect(MockMvcResultMatchers.status().isNoContent());
}




@Test
@Order(33)
public void Day6_testGetTaskById_StatusNotFound() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/123"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.content().string("Task not found with id 123"));
}


	@Test
	@Order(34)
    void Day7_test_TaskController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on TaskController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ TaskController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in TaskController.");
        }
    }


	@Test
	@Order(35)

    void Day7_test_TaskController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable annotation found in any method parameter of TaskController");

        } catch (ClassNotFoundException e) {
            fail("❌ TaskController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in TaskController.");
        }
    }


	@Test
	@Order(36)
    void Day7_test_UserController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on UserController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in UserController.");
        }
    }


    @Test
	@Order(37)
    void Day7_test_CommentController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CommentController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on CommentController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ CommentController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in CommentController.");
        }
    }



	@Test
	@Order(38)
    void Day7_test_UserController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.UserController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in UserController.");
        }
    }


    @Test
	@Order(39)
    void Day7_test_CommentController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CommentController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of UserController");

        } catch (ClassNotFoundException e) {
            fail("❌ UserController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in UserController.");
        }
    }


    @Test
	@Order(40)
    void Day7_test_TaskAssignment_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.TaskAssignmentController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            // Check class-level annotation
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            // Check method-level annotation
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on TaskAssignmentController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ TaskAssignmentController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in TaskAssignmentController.");
        }
    }







	@Test
	@Order(41)
    void Day8_test_TaskService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/TaskService.java").isFile());
    }

@Test
@Order(42)

void Day8_test_UserService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/UserService.java").isFile());
}

@Test
@Order(43)

void Day8_test_TaskStatusLogService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/TaskStatusLogService.java").isFile());
}

@Test
@Order(44)

void Day8_test_TaskAssignmentService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/TaskAssignmentService.java").isFile());
}


@Test
@Order(45)

void Day8_test_CommentService_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/CommentService.java").isFile());
}


@Test
@Order(46)
void Day8_test_TaskServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/TaskServiceImpl.java").isFile());
}

@Test
@Order(47)

void Day8_test_UserServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/UserServiceImpl.java").isFile());
}

@Test
@Order(48)

void Day8_test_TaskStatusLogServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/TaskStatusLogServiceImpl.java").isFile());
}

@Test
@Order(49)

void Day8_test_TaskAssignmentServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/TaskAssignmentServiceImpl.java").isFile());
}

@Test
@Order(50)

void Day8_test_CommentServiceImpl_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/service/CommentServiceImpl.java").isFile());
}

    @Test
    @Order(51)
    public void Day8_testAddUser() throws Exception {
        String requestBody = "{ \"name\": \"John Doe\", \"email\": \"john@example.com\", \"role\": \"ADMIN\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("ADMIN"));
    }

    // GET ALL USERS
    @Test
    @Order(52)
    public void Day8_testGetAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"));
    }

    // GET USER BY ID
    @Test
    @Order(53)
    public void Day8_testGetUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"));
    }

    // UPDATE USER
    @Test
    @Order(54)
    public void Day8_testUpdateUser() throws Exception {
        String requestBody = "{ \"name\": \"John Smith\", \"email\": \"john.smith@example.com\", \"role\": \"USER\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.smith@example.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("USER"));
    }
    
    // GET NON-EXISTENT USER (404)
   
    // PAGINATION-LIKE CHECKS (if implemented in service)
    @Test
    @Order(55)
    public void Day9_testPaginationPageNumberApplied() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(0));
    }

    @Test
    @Order(56)
    public void Day9_testPaginationPageSizeApplied() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/1/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(10));
    }

    @Test
    @Order(57)
    public void Day9_testPaginationContentArrayExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
    }

    @Test
    @Order(58)
    public void Day9_testPaginationTotalElementsExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").exists());
    }

    @Test
    @Order(59)
    public void Day9_testPaginationTotalPagesExists() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").exists());
    }


    @Test
    @Order(60)
    public void Day10_testAddTask() throws Exception {
        String requestBody = "{ \"title\": \"Sample Task\", \"description\": \"This is a test task\", \"priority\": \"MEDIUM\", \"status\": \"OPEN\", \"dueDate\": \"2025-12-15\", \"createdBy\": { \"id\": 1 } }";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Sample Task"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("This is a test task"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priority").value("MEDIUM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OPEN"))
                .andReturn();
    }

    @Test
    @Order(61)
    public void Day10_testGetAllTasks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Sample Task"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("This is a test task"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].priority").value("MEDIUM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("OPEN"))
                .andReturn();
    }

    @Test
    @Order(62)
    public void Day10_testGetTaskById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Sample Task"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("This is a test task"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priority").value("MEDIUM"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OPEN"))
                .andReturn();
    }

    @Test
    @Order(63)
    public void Day10_testUpdateTaskStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/tasks/1/status")
                .param("status", "IN_PROGRESS")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("IN_PROGRESS"))
                .andReturn();
    }

    @Test
    @Order(64)
    public void Day10_testGetTasksByUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/user/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Sample Task"))
                .andReturn();
    }

    // POST /api/status-logs
@Test
@Order(65)
public void Day10_testAddStatusLog() throws Exception {
    String requestBody = "{ \"oldStatus\": \"OPEN\", \"newStatus\": \"IN_PROGRESS\", \"task\": { \"id\": 1 }, \"changedByUser\": { \"id\": 1 } }";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/status-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.oldStatus").value("OPEN"))
            .andExpect(jsonPath("$.newStatus").value("IN_PROGRESS"))
            .andReturn();
}

// GET ALL STATUS LOGS
@Test
@Order(66)
public void Day10_testGetAllStatusLogs() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/status-logs")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].oldStatus").value("OPEN"))
            .andExpect(jsonPath("$[0].newStatus").value("IN_PROGRESS"))
            .andReturn();
}

// GET STATUS LOG BY ID
@Test
@Order(67)
public void Day10_testGetStatusLogById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/status-logs/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.oldStatus").value("OPEN"))
            .andExpect(jsonPath("$.newStatus").value("IN_PROGRESS"))
            .andReturn();
}

// GET LOGS BY TASK ID
@Test
@Order(68)
public void Day10_testGetLogsByTask() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/status-logs/task/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].task.id").value(1))
            .andExpect(jsonPath("$[0].oldStatus").value("OPEN"))
            .andExpect(jsonPath("$[0].newStatus").value("IN_PROGRESS"))
            .andReturn();
}

// GET USERS BY ROLE
@Test
@Order(69)
public void Day12_testGetUsersByRole() throws Exception {
    // Ensure test data exists (user with role "ADMIN" should exist)

    mockMvc.perform(MockMvcRequestBuilders.get("/api/users/role/USER")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Smith"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("john.smith@example.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value("USER"))
            .andReturn();
}

@Test
@Order(70)
public void Day12_testGetTasksByStatus() throws Exception {
    // First, create a task to ensure data exists
    String requestBody = "{ \"title\": \"JPQL Task\", \"description\": \"Task for JPQL test\", \"priority\": \"HIGH\", \"status\": \"OPEN\", \"dueDate\": \"2025-12-20\", \"createdBy\": { \"id\": 1 } }";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("JPQL Task"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OPEN"));

    // Now, test the JPQL query endpoint
    mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/status/OPEN")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("JPQL Task"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Task for JPQL test"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("OPEN"))
            .andReturn();
}

@Test
@Order(71)
public void Day12_testGetStatusLogsByOldStatus_NotFound() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/api/status-logs/old/Completed")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNoContent())
            .andExpect(MockMvcResultMatchers.content().string("No logs found with oldStatus: Completed"));
}


// NEGATIVE: Get assignments by non-existent userId
@Test
@Order(72)
public void Day12_testGetAssignmentsByUserId_NotFound() throws Exception {
//jpql
    mockMvc.perform(MockMvcRequestBuilders.get("/api/assignments/user/9999")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNoContent())
            .andExpect(MockMvcResultMatchers.content().string("No assignments found for user id: 9999"))
            .andReturn();
}

@Test
@Order(73)
public void Day12_testGetAssignmentsByUser_Positive() throws Exception {
//jpql
    mockMvc.perform(MockMvcRequestBuilders.get("/api/assignments/user/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNoContent())
            .andReturn();
}


@Test
@Order(74)
public void Day12_testGetTasksByStatus_NotFound() throws Exception {
//jpql
    mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks/status")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.content().string("No tasks found with status: UNKNOWN_STATUS"))
            .andReturn();
}

@Test
@Order(75)
    void Day13_test_execption_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }

@Test
@Order(76)
void Day13_test_GloabalEception_File_Exists() {
    assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
}


@Test
@Order(77)
    void Day14test_configuartion_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

@Test
@Order(78)
public void Day15_testAOPLogFileExists() {

    assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
   
}

}