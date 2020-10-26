DESCRIPTION = "enigma2-plugin-extensions-yahooweather"
MAINTAINER = "original by m43c0 and mmark and mod by mogli123"
SECTION = "extra"
PRIORITY = "optional"

require conf/license/license-gplv2.inc

inherit autotools-brokensep gitpkgv autotools gettext rm_python_pyc no_python_src

PV = "1.2.+git${SRCPV}"
PKGV = "1.2.+git${GITPKGV}"

SRC_URI="git://github.com/oe-alliance/YahooWeather.git"

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/*.py"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
"
CONFFILES_${PN} = " \
    ${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/Config/Location_id \
    ${libdir}/enigma2/python/Plugins/Extensions/YahooWeather/Config/Region_id "
