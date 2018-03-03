# Git Workflow

For using Git on this project, the preferred workflow for when a developer is working on the ticket entails the following steps, categorized chronologically as to what the developer should do every time they start on a new task.

## Branches

* **master** - This branch is only for release-quality code. This should never have any commits pushed to it directly.
* **develop** - This branch is used for development work and is usually more up-to-date than master. Pull requests should merge with this branch
* **any-ticket-branches** - As developers work on tickets, many other ticket branches will appear. Details for this branch are provided below.

## Before starting on a new task

When a task is chosen to be implemented by a developer, they will need to follow these steps before working on the project:

1. Create a new Git branch called 'branch${TICKET_NUMBER}-${TITLE_OF_TICKET}' where TICKET_NUMBER represents the issue number of that specific ticket, and TITLE_OF_TICKET is a **pascal case** version of the ticket title. To quickly create a new branch you can use the terminal command: `git checkout -b ${BRANCH_NAME}`.
   * EXAMPLE: For Ticket #23 titled "Add Testing Framework" the branch would be called `branch23-AddTestingFramework`. To create this new branch, you will execute `git checkout -b branch23-AddTestingFramework`
2. Git checkout into the newly created branch and make sure you are in the branch. Run `git status` to ensure you are on the right branch.
3. Push this branch up to the origin repository. The command-line interface command to execute would be something like `git push origin ${BRANCH_NAME}` where BRANCH_NAME is the branch you are now working on.
   * EXAMPLE: Using the previous ticket example, you will execute the command `git push origin branch23-AddTestingFramework`
4. Your new branch is now up on the GitHub repository and on your local Git. From here, start implementing the feature or fixing the bug!

## Finishing the task

When a task is finished and meets the requirements per the ticket according to the developer, they are ready to make a pull-request to get their new code verified and reviewed by the other developers. Use the following steps to make a pull-request:

1. Ensure all your changes are checked in (committed) to your local branch and not another branch like master. To verify this run `git status`.
2. Once the changes have been verified, go ahead and merge the develop branch into your local branch. This will help resolve any possible merge conflicts that might occur during the pull request. Run `git merge develop` while you are in your local branch to do this.
3. Once the merge conflicts have been fixed locally, you are ready to make the pull request. Push your changes from your local ticket branch to the origin ticket branch. To do this you would execute `git push origin ${BRANCH_NAME}` where BRANCH_NAME is the name of the branch you created for the particular ticket.
4. When the push goes through, open up the [GitHub repository](https://github.com/BoiseState/interfaith-donation) and click on the "Pull requests" tab on the top.
5. Click on new pull request, and choose to have your ticket branch be merged into the develop branch. **Don't merge with master, that branch is reserved only for new releases**.
   * For help in making a Pull Request, more specific information is provided at [About Pull Requests](https://help.github.com/articles/about-pull-requests/)
6. In the Pull Request description, add a link back to the original ticket you worked on along with information about that bug or feature you implemented.
7. Once the pull request has been made, go ahead and let the other developers know so that they can code review it to see if everything looks good. You can either request a reviewer, or post a heads up on the Slack channel "code-review".
8. When at least two developers have reviewed your code then you can go ahead and merge the branch into develop. This can be done on the pull request page by clicking on the "Merge" button.
