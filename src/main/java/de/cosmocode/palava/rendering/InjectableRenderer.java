/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.palava.rendering;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import de.cosmocode.rendering.ForwardingRenderer;
import de.cosmocode.rendering.Mapping;
import de.cosmocode.rendering.Renderer;

/**
 * A {@link Inject} aware {@link Renderer}.
 *
 * @since 1.1
 * @author Willi Schoenborn
 */
final class InjectableRenderer extends ForwardingRenderer {

    private final Renderer renderer;
    
    @Inject
    InjectableRenderer(@Backing Renderer renderer) {
        this.renderer = Preconditions.checkNotNull(renderer, "Renderer");
    }
    
    @Override
    protected Renderer delegate() {
        return renderer;
    }
    
    @Inject(optional = true)
    @Override
    public void setMapping(Mapping mapping) {
        super.setMapping(mapping);
    }

}
