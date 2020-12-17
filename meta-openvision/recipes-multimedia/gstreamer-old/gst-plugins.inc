SUMMARY = "Plugins for the GStreamer multimedia framework"
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"
DEPENDS = "gstreamer"

inherit autotools pkgconfig gobject-introspection

SRC_URI = "http://gstreamer.freedesktop.org/src/${BPN}/${BPN}-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-valgrind ${GSTREAMER_DEBUG} --disable-examples "

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

LIBV = "0.10"
require gst-plugins-package.inc

PACKAGES_DYNAMIC += "^${PN}-.*"

delete_pkg_m4_file() {
	# This m4 file is out of date and is missing PKG_CONFIG_SYSROOT_PATH tweaks which we need for introspection
	rm "${S}/common/m4/pkg.m4" || true
}

do_configure[prefuncs] += " delete_pkg_m4_file"

# apply gstreamer hack after Makefile.in.in in source is replaced by our version from
# ${STAGING_DATADIR_NATIVE}/gettext/po/Makefile.in.in, but before configure is executed
# http://lists.linuxtogo.org/pipermail/openembedded-core/2012-November/032233.html
oe_runconf_prepend() {
	if [ -e ${S}/po/Makefile.in.in ]; then
		sed -i -e "1a\\" -e 'GETTEXT_PACKAGE = @GETTEXT_PACKAGE@' ${S}/po/Makefile.in.in
	fi
}
