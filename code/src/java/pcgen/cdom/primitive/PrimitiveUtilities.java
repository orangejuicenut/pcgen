/*
 * Copyright (c) 2010 Tom Parker <thpr@users.sourceforge.net>
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 */
package pcgen.cdom.primitive;

import org.jetbrains.annotations.NotNull;
import pcgen.cdom.base.PrimitiveCollection;

import java.text.Collator;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class PrimitiveUtilities
{
	/**
	 * A COLLATOR used to sort Strings in a locale-aware method.
	 */
	private static final Collator COLLATOR = Collator.getInstance();

	private PrimitiveUtilities()
	{
	}

	public static final Comparator<PrimitiveCollection<?>> COLLECTION_SORTER =
			(lstw1, lstw2) -> COLLATOR.compare(lstw1.getLSTformat(false), lstw2.getLSTformat(false));

	@NotNull
	public static String joinLstFormat(
			@NotNull Collection<? extends PrimitiveCollection<?>> pcfCollection,
			@NotNull CharSequence separator, boolean useAny)
	{
		return pcfCollection.stream()
				  .map(pcf -> pcf.getLSTformat(useAny))
				  .collect(Collectors.joining(separator));
	}

}
