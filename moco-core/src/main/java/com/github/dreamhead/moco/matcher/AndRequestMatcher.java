package com.github.dreamhead.moco.matcher;

import com.github.dreamhead.moco.Request;
import com.github.dreamhead.moco.RequestMatcher;

public class AndRequestMatcher extends CompositeRequestMatcher {
    public AndRequestMatcher(final Iterable<RequestMatcher> matchers) {
        super(matchers);
    }

    @Override
    public boolean match(final Request request) {
        for (RequestMatcher matcher : matchers) {
            if (!matcher.match(request)) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected RequestMatcher newMatcher(Iterable<RequestMatcher> matchers) {
        return new AndRequestMatcher(matchers);
    }
}
