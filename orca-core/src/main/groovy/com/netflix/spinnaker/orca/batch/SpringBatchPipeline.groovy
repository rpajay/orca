/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.batch

import groovy.transform.CompileStatic
import com.netflix.spinnaker.orca.pipeline.Pipeline
import com.netflix.spinnaker.orca.pipeline.Stage
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.JobExecution

@CompileStatic
class SpringBatchPipeline extends Pipeline {

  private final JobExecution jobExecution

  SpringBatchPipeline(JobExecution jobExecution, List<Stage> stages) {
    super(jobExecution.id.toString(), stages)
    this.jobExecution = jobExecution
  }

  ExitStatus getExitStatus() {
    jobExecution.exitStatus
  }
}
