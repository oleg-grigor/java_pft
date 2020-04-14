$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bdd/groups.feature");
formatter.feature({
  "line": 1,
  "name": "Groups",
  "description": "",
  "id": "groups",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Group creation",
  "description": "",
  "id": "groups;group-creation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I create a new group with name \u003cname\u003e, header \u003cheader\u003e and footer \u003cfooter\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the new set of groups is equal to the old set with the added group",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "groups;group-creation;",
  "rows": [
    {
      "cells": [
        "name",
        "header",
        "footer"
      ],
      "line": 9,
      "id": "groups;group-creation;;1"
    },
    {
      "cells": [
        "test name",
        "test header",
        "test footer"
      ],
      "line": 10,
      "id": "groups;group-creation;;2"
    },
    {
      "cells": [
        "test name1",
        "test header1",
        "test footer 1"
      ],
      "line": 11,
      "id": "groups;group-creation;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 12349205200,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Group creation",
  "description": "",
  "id": "groups;group-creation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I create a new group with name test name, header test header and footer test footer",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the new set of groups is equal to the old set with the added group",
  "keyword": "Then "
});
formatter.match({
  "location": "GroupStepDefinitions.loadGroups()"
});
formatter.result({
  "duration": 597272400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test name",
      "offset": 31
    },
    {
      "val": "test header",
      "offset": 49
    },
    {
      "val": "test footer",
      "offset": 72
    }
  ],
  "location": "GroupStepDefinitions.createGroup(String,String,String)"
});
formatter.result({
  "duration": 2417217100,
  "status": "passed"
});
formatter.match({
  "location": "GroupStepDefinitions.verifyGroupCreated()"
});
formatter.result({
  "duration": 18850900,
  "status": "passed"
});
formatter.after({
  "duration": 1651253700,
  "status": "passed"
});
formatter.before({
  "duration": 7735065900,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Group creation",
  "description": "",
  "id": "groups;group-creation;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I create a new group with name test name1, header test header1 and footer test footer 1",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the new set of groups is equal to the old set with the added group",
  "keyword": "Then "
});
formatter.match({
  "location": "GroupStepDefinitions.loadGroups()"
});
formatter.result({
  "duration": 44754300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test name1",
      "offset": 31
    },
    {
      "val": "test header1",
      "offset": 50
    },
    {
      "val": "test footer 1",
      "offset": 74
    }
  ],
  "location": "GroupStepDefinitions.createGroup(String,String,String)"
});
formatter.result({
  "duration": 2486091600,
  "status": "passed"
});
formatter.match({
  "location": "GroupStepDefinitions.verifyGroupCreated()"
});
formatter.result({
  "duration": 10929300,
  "status": "passed"
});
formatter.after({
  "duration": 1685723400,
  "status": "passed"
});
});