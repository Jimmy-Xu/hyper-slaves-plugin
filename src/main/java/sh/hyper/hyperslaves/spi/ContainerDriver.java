/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 HyperHQ Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package sh.hyper.hyperslaves.spi;

import hudson.Launcher;
import hudson.Proc;
import hudson.slaves.SlaveComputer;
import sh.hyper.hyperslaves.ContainerInstance;

import java.io.IOException;

public interface ContainerDriver {

    boolean hasContainer(Launcher launcher, String id) throws IOException, InterruptedException;

    ContainerInstance createAndLaunchSlaveContainer(final SlaveComputer computer, Launcher launcher, String image, String size) throws IOException, InterruptedException;

    Proc execInSlaveContainer(Launcher launcher, String containerId, Launcher.ProcStarter starter) throws IOException, InterruptedException;

    int removeContainer(Launcher launcher, ContainerInstance instance) throws IOException, InterruptedException;

    void pullImage(Launcher launcher, String image) throws IOException, InterruptedException;

    boolean checkImageExists(Launcher launcher, String image) throws IOException, InterruptedException;
}
