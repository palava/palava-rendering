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
