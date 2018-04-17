# Back-end Integration Testing Plan and Notes

## Overview
This document serves to list recommended guidelines to follow when writing integration tests for changes to the back end. The information in this document is intended for use with the Java Spring API code written in this repository.
## Creating Tests
When writing integration tests, ensure that they use components that require other components within them. For example, if the component named "X" contains a value called "y_id" which is part of a "Y" component, appropriate tests should be made to verify the interaction between Y and X. Ideally, tests should be created in a "bottom-up" manner, meaning the smaller modules of components, i.e. a pair of components, and their interactions should be tested until interactions between the largest sets of components is executed and passes.
#### Note:
Unit tests should already exist for parts of X and Y that work independently with respect to the two components.
## Revising Tests
When changes are made to a component in either its model, controller, or repository, integration tests containing method calls related to that component should be verified and adjusted as necessary.
## Execution of Tests
All integration tests should be able to execute through any IDE (particularly Eclipse or Intellij IDEA). They should provide clear information about any errors that occur during their run. It should be easy to tell a success from a failure. 
## Reminders
Remember good testing habits and try to not duplicate test code or complicate the tests when writing them.
