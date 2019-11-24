MODULE = "RemoteChannelStreamConverter"
DESCRIPTION = "Fetch channels from remote bouquets and make them available locally"

RDEPENDS_${PN} = "python-shell"

require conf/license/license-gplv2.inc
require openplugins-replace-vision.inc
require openplugins-distutils.inc
