/*
 * Java GPX Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package io.jenetics.jpx.jdbc.model;

import io.jenetics.jpx.Link;
import io.jenetics.jpx.jdbc.internal.db.Stored;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public final class LinkRow {
	public final long id;

	public String href;
	public String text;
	public String type;

	public LinkRow(
		final long id,
		final String href,
		final String text,
		final String type
	) {
		this.id = id;
		this.href = href;
		this.text = text;
		this.type = type;
	}

	public LinkRow(final long id) {
		this.id = id;
	}

	public LinkRow fill(final LinkRow link) {
		href = link.href;
		text = link.text;
		type = link.type;
		return this;
	}

	public LinkRow copy() {
		return new LinkRow(id, href, text, type);
	}

	public Link toLink() {
		return Link.of(href, text, type);
	}

	public static LinkRow of(final Stored<Link> link) {
		return new LinkRow(
			link.id(),
			link.value().getHref().toString(),
			link.value().getText().orElse(null),
			link.value().getType().orElse(null)
		);
	}

}