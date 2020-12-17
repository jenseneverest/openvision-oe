require python-setuptools.inc
inherit setuptools3

SRC_URI[md5sum] = "260630ae1a64bafa39dcc53404d63829"
SRC_URI[sha256sum] = "012adb8e25fbfd64c652e99e7bab58799a3aaf05d39ab38561f69190a909015f"

do_install_append() {
    mv ${D}${bindir}/easy_install ${D}${bindir}/easy3_install
}

BBCLASSEXTEND = "native nativesdk"

# The pkg-resources module can be used by itself, without the package downloader
# and easy_install. Ship it in a separate package so that it can be used by
# minimal distributions.
PACKAGES =+ "${PYTHON_PN}-pkg-resources "
FILES_${PYTHON_PN}-pkg-resources = "${PYTHON_SITEPACKAGES_DIR}/pkg_resources/*"
RDEPENDS_${PYTHON_PN}-pkg-resources = "\
  ${PYTHON_PN}-compression \
  ${PYTHON_PN}-email \
  ${PYTHON_PN}-plistlib \
  ${PYTHON_PN}-pprint \
"
# Due to the way OE-Core implemented native recipes, the native class cannot
# have a dependency on something that is not a recipe name. Work around that by
# manually setting RPROVIDES.
RDEPENDS_${PN}_append = " ${PYTHON_PN}-pkg-resources"
RPROVIDES_append_class-native = " ${PYTHON_PN}-pkg-resources-native"
