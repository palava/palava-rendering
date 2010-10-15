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

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

import de.cosmocode.rendering.CollectionRenderer;
import de.cosmocode.rendering.DefaultListRenderer;
import de.cosmocode.rendering.DefaultMapRenderer;
import de.cosmocode.rendering.ListRenderer;
import de.cosmocode.rendering.MapRenderer;
import de.cosmocode.rendering.Renderer;

/**
 * Binds {@link Renderer} to {@link CollectionRenderer} and provides
 * {@link MapRenderer} and {@link ListRenderer} through
 * {@link DefaultMapRenderer} and {@link DefaultListRenderer} respectively.
 *
 * @author Willi Schoenborn
 */
public final class CollectionRenderingModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(Renderer.class).annotatedWith(Backing.class).to(CollectionRenderer.class);
        binder.bind(Renderer.class).to(InjectableRenderer.class);
    }
    
    /**
     * Provides a {@link MapRenderer} view of the specified renderer.
     * 
     * @param renderer the backing renderer
     * @return a {@link MapRenderer}
     */
    @Provides
    MapRenderer provideMapRenderer(Renderer renderer) {
        return new DefaultMapRenderer(renderer);
    }
    
    /**
     * Provides a {@link ListRenderer} view of the specified renderer.
     * 
     * @param renderer the backing renderer
     * @return a {@link ListRenderer}
     */
    @Provides
    ListRenderer provideListRenderer(Renderer renderer) {
        return new DefaultListRenderer(renderer);
    }

}
