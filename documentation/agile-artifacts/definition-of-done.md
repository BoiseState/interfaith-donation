# Definition of Done

#### This is what is required for our team to consider a user story "done":

* Unit-Level Tests Passing

  1. Backend - All completed task needs to pass all accompanying unit tests before sprint completion.
  2. Frontend - New features being added will require functionality testing of previous features.

* Static Analysis Passing

  1. Code passes review by static analysis tools (for now, just ESLint)

* Code Reviews (Simple rule for now: If you don't have unit-level tests for some code, then you need reviews for that code)

  1. At least one another developer must review the code that was submitted before it can be considered done.
  2. For a code review to be considered complete the reviewer must review all changes made to the code base.

* Acceptance Tests

  1. All unit tests for acceptance criteria are both created and passing.

* Integration Tests

  1. N/A at the moment. Eventually, our continuous integration tools will run integration tests on code pushed to master.

* Documentation
  1. If applicable, either create or update documentation in the wiki for the task.

Overall goal of DoD:
Design principles used to ensure that we have a working project that meets sponsors needs and acceptance criteria.

### Defect Removal Pipeline

* Defect Removal Activities
  1. Pair Programming
  2. Test Driven Development
  3. Unit Testing
  4. Static Analysis
  5. Code Reviews
  6. Acceptance Test
  7. Integration Testing
  8. Beta Testing

Justification:
We've chosen to include test-driven development, unit testing, static analysis, code reivews, acceptance testing, integration testing, and beta testing in our defect removal pipeline. Using
the assumptions about defect removal effectiveness given in class for each activity, this pipeline should produce a delivered defect density of about 4.39 defects/ KLOC. We've chosen to use
this pipline because test driven development, unit testing, code reviews, and acceptance testing fit in well with our definition of done. Beta testing by the client will occur naturally since our team is using scrum
(our sponsor will test our product), and we already use pair programming frequently, as many of our team members are just now learning the technologies we're using to build our product. Finally, static analysis
will be a low-cost defect removal activity and help save time in our code reviews once we've found an appropriate static analysis tool, and integration testing incorporates well with our stretch goal to use
